# SET terminal
import math
import pygame as pg
# Nodes array stores each command that has been performed
# this will make it easier to add undo ?
# its a bit inefficient tho
global Nodes
Nodes = []
running = True
filen = ''
pendown = True
save = 0

pg.init()
screen = pg.display.set_mode((700,1000))
screen.fill((255,255,255))
# setting font , and what color to show when box is active
COLOR_ACTIVE = pg.Color('skyblue')
COLOR_INACTIVE = pg.Color('black')
FONT = pg.font.Font(None, 32)

pg.draw.circle(screen,(255,0,0),(300,300),2)
class Turtle:

    def __init__(self):
        self.x = 300
        self.y = 300
        self.angle = 270.0
        self.color = (0, 0, 0)

    def draww(self):
        # draws the top box indicating which direction you're facing
        pg.draw.rect(screen,(0,0,0),(0,0,20,20))
        if pendown:
            pg.draw.rect(screen, (0, 0, 0), (0, 30, 20, 20))
        x = 10+10*math.cos(self.angle*3.141592/180)
        y = 10+10*math.sin(self.angle*3.141592/180)
        pg.draw.line(screen,(255,0,0),(10,10),(x,y))

    global pendown
    global ctrl
    ctrl = 0
    def interpret(self, stmnt):
        global ctrl
        # interprets the commands
        if "move" in stmnt:
            s = stmnt.replace(' ', '')
            a = int(s[s.index('(') + 1:s.index(')')])
            global pendown
            if pendown:
                # basically tilts the line if any angle
                pg.draw.line(screen, self.color, (self.x, self.y),
                         (self.x + a * math.cos(self.angle*3.141592/180), self.y + a * math.sin(self.angle*3.141592/180)))
            self.x = (self.x + a * math.cos(self.angle*3.141592/180))
            self.y = self.y + a * math.sin(self.angle*3.141592/180)
            pg.draw.circle(screen, (0, 255, 255), (self.x, self.y), 3)

        if "turn" in stmnt:
            s = stmnt.replace(' ', '')
            a = self.angle+int(s[s.index('(') + 1:s.index(')')])
            # takes care of negative angle
            a+=360
            a%=360
            self.angle = a
            self.draww()

        if "erase" in stmnt:
            self.color = (255,255,255)
            pg.draw.rect(screen, (0, 0, 0), (0, 30, 20, 20))
            pg.draw.rect(screen, (255, 200, 200), (1, 31, 18, 18))
            pg.draw.circle(screen, (0, 255, 255), (self.x, self.y), 3)

        if "pendown" in stmnt:
            self.color = (0,0,0)
            pg.draw.rect(screen, (0, 0, 0), (0, 30, 20, 20))
            pendown = True

        if "penup" in stmnt:
            pendown = False
            pg.draw.rect(screen, (255, 255, 255), (0, 30, 20, 20))
        # if "undo" in stmnt:
        #     screen.fill((255, 255, 255))
        #     # Nodes.pop(len(Nodes)-1)
        #     del Nodes[-1]
        #     self.x = 300
        #     self.y = 300
        #     self.angle=270.0
        #     turtle.draww()
        #     ctrl = 1
        #     for i in Nodes:
        #         turtle.interpret(i)



        if ctrl != 1:
            Nodes.append(stmnt+"\n")


turtle = Turtle()
am = input('open existing file ?\n').lower()
if 'yes' in am:
    filen = input('enter filename:')
    file = open(filen)
    para = file.read()+'\n'
    # splits lines into array elements
    while len(para) !=0:
        line = (para[0:para.index('\n')])
        turtle.interpret(line)
        para= para[para.index('\n')+1:len(para)]

turtle.draww()
# i confess i took this from stack overflow and made a few changes
class InputBox:
    global save

    global running
    def __init__(self, x, y, w, h, text=''):
        self.rect = pg.Rect(x, y, w, h)
        self.color = COLOR_INACTIVE
        self.text = text
        self.txt_surface = FONT.render(text, True, self.color)
        self.active = False

    def handle_event(self, event):
        global save
        if event.type == pg.MOUSEBUTTONDOWN:
            # If the user clicked on the input_box rect.
            if self.rect.collidepoint(event.pos):
                # Toggle the active variable.
                self.active = not self.active
            else:
                self.active = False
            # Change the current color of the input box.
            self.color = COLOR_ACTIVE if self.active else COLOR_INACTIVE
            self.txt_surface = FONT.render(self.text, True, self.color)
        if event.type == pg.KEYDOWN:
            if self.active:
                if event.key == pg.K_RETURN:
                    # if save is one , that means the file is to be saved and the filename is being asked
                    # hence the [9:...]
                    if save == 1:
                        self.text = self.text[9:len(self.text)]
                        if self.text.endswith('.set'):
                            self.text=self.text[0:self.text.index('.set')]
                        filename = self.text+".set"
                        print(filename)
                        try:
                            # tries to create a file
                            file2 = open(filename, "x")
                        except:
                            # appends to existing file
                            file2 = open(filename, "+r")
                        for i in Nodes:
                            file2.write(i)
                        file2.write("eof\n")
                        # print(Nodes)
                        # print(file)
                        exit()
                    else:
                        # if save !=1 then just normally treat input as a command instead of filename
                        turtle.interpret(self.text)
                        # print('k')
                        self.text = ''
                elif event.key == pg.K_BACKSPACE:
                    self.text = self.text[:-1]
                elif event.key == pg.K_TAB:
                    #  the '+filen' is in case you are appending to an existing file
                    #  you don't have to type the name again
                    self.text="filename:"+filen
                    self.txt_surface = FONT.render(self.text, True, self.color)
                    save =1
                #     so the tab key is to save and exit

                else:
                    self.text += event.unicode
                # Re-render the text.
                self.txt_surface = FONT.render(self.text, True, self.color)


    def update(self):
        # Resize the box if the text is too long.
        width = max(600, self.txt_surface.get_width()+10)
        self.rect.w = width

    def draw(self, screen2):
        # blit apparently makes it easier to draw stuff ... seems same though
        # Blit the text.
        screen2.blit(self.txt_surface, (self.rect.x+5, self.rect.y+5))
        # Blit the rect.
        pg.draw.rect(screen2, self.color, self.rect, 2)



box = InputBox(50,600,600,50)
while running:
    # standard display and event handling
    for e in pg.event.get():
        if e.type == pg.QUIT:
            running = False
        pg.draw.rect(screen,(0,0,255),(0,500,700,500))
        box.draw(screen)
        box.handle_event(e)
        box.update()
    pg.display.flip()

pg.quit()

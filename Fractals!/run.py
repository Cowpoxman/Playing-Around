# importing modules
import pygame
import math


# initializing pygame and screen
pygame.init()
running = True
screen = pygame.display.set_mode([600, 600])
screen.fill((255, 255, 255))


done = 0
c = 0
# pygame loop
print('please wait...')
while running:


    # pygame.draw.rect(screen, (255, 0, 0), (0,0,5,5))
    # also ignore the 'done' thing . it just ensures that it runs once
    if done==0:
        for x in range(601):
            for y in range(601):
                # mapping x and y from (0,600) -> (-2,2) to make it fit in the screen and the numbers generated are also a bit smaller
                x1=0.006*(x-300)
                y1=0.006*(y-300)
                # a = complex(x1,y1)
                a = complex((x1-28.3)/90, (y1-26.8)/90)
                c = a
                # comment out above line and uncomment below line for julia
                # c= complex(0.006*(pygame.mouse.get_pos()[0]-300),0.006*(pygame.mouse.get_pos()[1]-300)) # interactive julia set
                nope=0
                # nope is a control variable
                # 'try' is needed to prevent overflow errors from python
                try:
                    # change 50 to 30 for real time julia visualization
                    for i in range(50):
                        # insert iterative function
                        # a =  complex(a.imag+a.real,a.imag-a.real)**2 + c
                        # a = complex(a.real*a.imag,a.real+a.imag)**2 + c
                        # a = a**2 + c  # mandelbrot
                        # a = a**2 + c
                        # a = a*c

                        # a = complex(c.real**(a.real*5),c.imag**(a.imag*5))
                        a = a**3 - a**2 + c
                        # a = a**(abs(a.real))
                        # a= a**abs(a.imag)
                        # a = (a.conjugate() - a.imag)**abs(a.real) + c
                        # a = (a.conjugate() + (a.real**2 + a.imag**2)**0.5)**2 + c
                        # a = (a.real ** 2 + a.imag ** 2) + c
                        # a = (a.conjugate()/(a.real ** 2 + a.imag ** 2))**2 + c
                        # a = complex(abs(a.real),abs(a.imag))**2 + c  #burning ship
                        # a = complex(a.imag,a.real)**2 - complex(a.imag,a.real)**3 + a+ c #jellyfish fractal
                        # a = complex(a.imag, a.real)**3 + c
                        # a = complex(a.real*math.tan(a.imag),a.imag*math.tan(a.real))**2 + c #oblong thingy
                        # a = complex(a.real * math.atan(a.imag), a.imag * math.atan(a.real)) ** 2 + c #gave unexpected smooth line


                        # checks mid iteration to see if it blows up
                        if a.real > 99999 or a.imag > 99999:
                            nope = 1


                            if i < 5:
                                screen.set_at((x, y), (70, 0, 225))
                            elif i < 10:
                                screen.set_at((x, y), (100,0, 255))
                            elif i < 16:
                                # blows up fast , colour assigned is violet ish
                                screen.set_at((x,y),(150,50,255))
                            elif i < 24:
                                screen.set_at((x, y), (50, 205, 128))
                            elif i <32:
                                # blows up slightly slower , colour is green
                                screen.set_at((x,y),(0,255,0))
                            else:
                                # blows up slowly so red
                                screen.set_at((x,y),(255,100,0))
                                screen.set_at((x,y),(255,100,0))
                            break

                    if (nope==0) and a.real < 99999 and a.imag < 99999:
                        screen.set_at((x,y),(0,0,0))
                except:
                    # white indicates out of bounds for this program
                    screen.set_at((x,y),(255,255,255))
            # comment out 'done += 1' for julia set
            done += 1
    # other useless pygame stuff

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            running = False
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_q:
                exit()



    pygame.display.flip()




pygame.quit()

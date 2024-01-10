from bs4 import BeautifulSoup
import requests
req = ''
recursion_depth = 0
max_limit = int(input('Enter max recursion depth ! :'))
visited = []
current = ''
def scrape(url):
    global visited
    # if url.endswith('/') == False:
    #     URL = url + '/'
    if len(visited) >=300:
        visited = visited[280:300]
    URL = url
    global req
    global recursion_depth

    global current
    if recursion_depth<=2 and URL not in visited:
        try:
            req = requests.get(URL)
            soup = BeautifulSoup(req.text, "html.parser")
            visited.append(URL)
            for link in soup.find_all():
                name = str(link.get('href'))
                if link.get('href') != None and link.get('href') not in visited and name.startswith('http'):

                    # if name.startswith('/'):
                    #     name = URL + name[1:]
                    print(str('-'*recursion_depth) + name)
                    # print(link.get('href'))
                    # current = link.get('href')
                    recursion_depth += 1

                    scrape(name)
                # if link.get('src') != None and link.get('src')!=current:
                #     print(link.get('src'))
                #     current = link.get('src')
        except:
            pass

    elif recursion_depth > max_limit:
        recursion_depth = 0
        print(len(visited))
        

scrape(input('enter url: '))

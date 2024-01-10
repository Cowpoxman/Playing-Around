################################
##           AXOLOTL          ##
##    Custom scanning tool    ##
## Brute force web subdomains ##
################################

import requests
url = input("enter website name: ")
file = open("dir.txt")
dirs = file.read().splitlines()
doubtful = []
for i in dirs:
    x = requests.get(url+"/"+i)
    stat = int(x.status_code)
    UR = x.history
    URL = ''
    if len(UR) > 1:
        URL = UR[len(UR)-1].url
        # print(UR)
        if URL.endswith('/'):
            URL = URL[0:len(URL)-1]
        URL = URL[URL.rindex('/'):]
    if stat < 400 :
        redirects = ''
        if '/'+URL != str(i):
            redirects = URL
        if URL != '404' and URL != '':
            print("axolotl found :  /" + i + (" " * (20 - len(i))) + str(stat) + "      redirects to:  "+ URL)
print("scan complete")
# if 'y' in input('see doubtful ?[Y/N]  ').lower():
#     for k in doubtful:
#         print(k)

# if 'page cannot be found' in txt or '404' in txt:
#     doubtful.append("axolotl found :  /" + i + "\t" + str(stat) +"    doubtful")
# # elif stat >= 300 and stat <=399:
# #     print(i + "  redirects")

from bs4 import BeautifulSoup
import requests

# gather a listOfQueries 

with open("QueryLines.txt", "r") as f:
    lines  = f.read().split("querystring=\"")
    del lines[0]

    listOfQueries = []

    for line in lines:
        queryLine = line.split("\"")
        listOfQueries.append(queryLine[0])
        
    print(listOfQueries)
    #print(len(listOfQueries))

f.close

# getting html from url

for i in range (5):

    url = f"https://www.singaporepools.com.sg/en/product/sr/Pages/toto_results.aspx?{listOfQueries[i]}"
    result = requests.get(url)
    doc = BeautifulSoup(result.text, "html.parser")
    hotVenues = doc.find_all("li")
    with open("HotVenues.txt", "a") as f:

        for venue in hotVenues:
            if (venue.string != None):
                print(venue.string)
                f.write(venue.string)
    
    f.close


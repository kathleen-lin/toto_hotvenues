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
        
    #print(listOfQueries)
    #print(len(listOfQueries))

f.close

# getting html from url

for i in range (len(listOfQueries)):

    url = f"https://www.singaporepools.com.sg/en/product/sr/Pages/toto_results.aspx?{listOfQueries[i]}"
    result = requests.get(url)
    doc = BeautifulSoup(result.text, "html.parser")
    number1 = doc.find("td", class_="win1")
    number2 = doc.find("td", class_="win2")
    number3 = doc.find("td", class_="win3")
    number4 = doc.find("td", class_="win4")
    number5 = doc.find("td", class_="win5")
    number6 = doc.find("td", class_="win6")
    number7 = doc.find("td", class_="additional")



    with open("PopularNumbers.txt", "a") as f:

        f.write(number1.string)
        f.write("\n")
        f.write(number2.string)
        f.write("\n")
        f.write(number3.string)
        f.write("\n")
        f.write(number4.string)
        f.write("\n")
        f.write(number5.string)
        f.write("\n")
        f.write(number6.string)
        f.write("\n")
        f.write(number7.string)
        f.write("\n")
    
    f.close


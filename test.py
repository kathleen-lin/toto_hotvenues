import requests
from bs4 import BeautifulSoup

url = "https://www.singaporepools.com.sg/en/product/sr/Pages/toto_results.aspx?sppl=RHJhd051bWJlcj0zODM5"
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3'}

result = requests.get(url, headers=headers)
doc = BeautifulSoup(result.text, "lxml")

draw_date_select = doc.select_one(".form-control.selectDrawList")
draw_date_options = draw_date_select.find_all("option")

links = [option["value"] for option in draw_date_options]

print(links)

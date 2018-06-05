# CSV parser

### Main page: http://localhost:8080/index.html
### Api doc: http://localhost:8080/swagger-ui.html

The task is to write a web application which consumes data from three different data sources - represented as CSV files:
1.	DataStore1.csv
2.	DataStore2.csv
3.	DataStore3.csv

These contain key-value pairs.

The requirements are:
*	there should be a page with a single button labelled as "Get data"
*	upon clicking it on the result page the values should be alphabetically ordered and colored as:
*	data from DataStore1 should be blue
*	data from DataStore2 should be green
*	data from DataStore3 should be red
*	all letters should be capital
*	if you can't sort based on the letter use the key to compare them - lower id should come first

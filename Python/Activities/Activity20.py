import pandas as pd

table=pd.read_excel("Activity19.xlsx",sheet_name="Sheet1")

print(table.shape)

print(table["Email"])

print(table.sort_values('FirstName'))
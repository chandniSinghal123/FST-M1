import pandas as pd

table=pd.read_csv("Activity17.csv")

print(table["Usernames"])
print(table["Usernames"][1],table["Passwords"][1])

table.sort_values("Usernames")
print(table["Usernames"])

table.sort_values("Passwords",ascending=False)
print(table["Passwords"])

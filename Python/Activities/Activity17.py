import pandas as pd
data = {
    "Usernames":["admin","Charles","Deku"],
    "Passwords":["password","Charl13","AllMight"]
}

table=pd.DataFrame(data)

print(table)

table.to_csv("Activity17.csv",index=False)
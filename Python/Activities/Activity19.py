import pandas as pd
data={
    "FirstName":["Satvik","Avinash","Lahri"],
    "LastName": ["Shah","Kati","Rath"],	
    "Email":["satshah@example.com","avinashk@example.com","lahri.rath@example.com"],
    "PhoneNumber":[4537829158,5892184058,4528727830]
    }

table=pd.DataFrame(data)

writer=pd.ExcelWriter('Activity19.xlsx')
table.to_excel(writer,"Sheet1",index=False)

writer.save()
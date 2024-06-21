list1=[1,2,3,4,5]
list2=[1,2,3,4,5]
list3=[]
for number in list1:
    if (number%2!=0):
        list3.append(number)
for number in list2:
    if (number%2==0):
        list3.append(number)
print(list3)
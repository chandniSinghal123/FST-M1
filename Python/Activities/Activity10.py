userTuple = eval(input("Enter a number in the format #(5,10,2,3) "))
print (userTuple)
for number in userTuple:
    if (number%5==0):
        print (number)
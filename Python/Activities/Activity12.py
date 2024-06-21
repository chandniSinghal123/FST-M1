def sum(num):
    if (num<=0):
        return num
    else:
        return num+sum(num-1)

print("Sum of number from 0 to 10 is : ",sum(10))
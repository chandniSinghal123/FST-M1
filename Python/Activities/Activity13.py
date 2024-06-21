def sum(num):
    sum1=0
    for x in num:
        sum1+=x
    return sum1

userInput = eval(input("Enter a list of numbers in the format #[1,2,3,4,5]: "))
print("sum of elements in list is: ",sum(userInput))
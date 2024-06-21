userInput = list(input("Enter user input: ").split(","))
sum=0

for number in userInput:
    sum+=int(number)

print(sum)
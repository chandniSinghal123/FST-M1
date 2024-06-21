userInput=input("Enter a fruit name: ").lower()
fruitDict={
    "mango":60,
    "apple":100,
    "banana":30
}
for fruit in fruitDict:
    if userInput == fruit:
        print(userInput, " is present")
        break
else:
    print(userInput, " is not present")
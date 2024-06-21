def fibo(i):
    if i<=1:
        return i
    else:
        return fibo(i-1)+fibo(i-2)

userInput=int(input("Enter a number: "))
print("Fibonacci Sequence: ")
for i in range(userInput):
    print(fibo(i))
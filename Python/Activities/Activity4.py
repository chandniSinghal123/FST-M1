player1 = input("Enter player1 name: ")
player2 = input("Enter player2 name: ")

while True:
    player1Answer = input("player1 Answer: ").lower()
    player2Answer = input("player2 Answer: ").lower()

    if player1Answer not in ["rock","scissors","paper"] or player2Answer not in ["rock","scissors","paper"]:
        print("Invalid Input! Please enter value from Rock, Scissors, Paper ")
    elif player1Answer == player2Answer:
        print("It's a Tie")
    elif (player1Answer == "rock"):
        if player2Answer == "scissors":
            print("player1 wins")
        else:
            print("player2 wins")
    elif (player1Answer == "scissors"):
        if player2Answer == "rock":
            print("player2 wins")
        else:
            print("player1 wins")
    elif (player1Answer == "paper"):
        if player2Answer == "rock":
            print("player1 wins")
        else:
            print("player2 wins")

    replay = input("Do you want to play again: Yes/No ").lower()
    if replay == "yes":
        pass
    elif replay== "no":
        raise SystemExit
    else:
        raise SystemExit    

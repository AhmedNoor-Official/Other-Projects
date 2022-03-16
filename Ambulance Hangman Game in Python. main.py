from time import sleep
from draw import *
from os import system, name

playAgain = True
while playAgain:



    # clear the screen
    def clear():           
        system('cls')        



    # find letter in word
    def existance(letter, word):
        return word.find(letter)


    # update asterik string if guess is correct
    def setguess(letter, word, guess):
        count = 0
        index = word.find(letter)
        while index >= 0:
            count += 1
            guess = guess[:index] + word[index] + guess[index + 1:]
            word = word[:index] + '*' + word[index + 1:]
            index = word.find(letter)
        return count, guess



    def checkwin(guess):       # find if all asteriks are found
        return guess.find("*") # word is guessed



    # steps to be performed by player one
    def move_pl1():
        print("=============== Player one's turn ===============\n")
        print("=== (Make sure player two is not peaking!) ===\n")
        word = input('Enter word: \n ')
        print("\n"*40)
        clear()
        guess = "*" * len(word)
        print(guess)
        return word, guess



    # steps to be performed by player two
    def move_pl2():
        print("=============== Player two's turn===============\n")
        letter = input('Guess a letter: ')
        clear()
        return letter


    # initialize variables
    if __name__ == "__main__":
        word, guess = move_pl1()
        ls_wrong = []
        tries = 8
        message = ""


        # initialize board
        init()
        design(guess, tries, message, ls_wrong)


        # repeats until number of tries
        while tries:
            message = ""
            letter = move_pl2()


            # checks to ensure length is one
            if(len(letter) > 1 or len(letter) < 1):
                print("\n(You must only guess and enter one letter at a time!!!) \n")
                print("*** Please try again ***\n")
                message = "You must only guess one letter at a time! \n !!! *** try again *** !!!"
            else:
                exists = existance(letter, word)


                # if letter doesn't exist in word
                if exists < 0:
                    tries -= 1
                    print("You guessed wrong! ")
                    print("*** Remaining tries *** ", tries)
                    message = "You guessed wrong! "
                    ls_wrong.append(letter)


                # if letter exists in word
                else:
                    temp, t_guess = setguess(letter, word, guess)


                    # checks for a previously entered letter
                    if(temp > 0 and t_guess == guess):
                        tries -= 1
                        print("already Searched!")
                        print("You guessed wrong! ")
                        print("*** Remaining tries *** ", tries)
                        message = "Already Searched!"
                    else:
                        guess = t_guess
                        print(guess)


                        # checks and prints message if player wins
                        if checkwin(guess) < 0:
                            print("You Win")
                            message = "!!!! *** Y O U   W I N *** !!!"
                            design(guess, tries, message, ls_wrong)
                            break
            design(guess, tries, message, ls_wrong)


        #  checks and prints message if player looses
        if tries == 0:
            print("*** You Lose! *** \n")
            message = "!!! *** Y O U   L O O S E *** !!!"
            design(guess, tries, message, ls_wrong)



    # asks players if they want to play again
    playReply = input("\n Do you want to play again?")
    if playReply.lower() in ["y","yes"]:
        playAgain = True
    elif playReply.lower() in ["n","no"]:
        playAgain = False

        getscreen()._root.mainloop()


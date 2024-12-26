export const defaultGame = {
    number: getRandomNumber(),
    guess: 0,
    pastGuesses:[],
    message: "Start guessing",
    gameOver: false,
}

function getRandomNumber() {
    console.log("getRandomNumber called");
    return Math.floor(Math.random() * 20 + 1);
  }

export function NumberReducer (state, action) {
    switch(action.type) {
        case "GUESS":{
            let newState = {...state};
            // Case: User guessed correctly
            if (newState.guess === newState.number) {
                newState.message = `You got it! the answer is ${newState.guess}`;
                newState.gameOver = true;
            } else if( newState.guess > newState.number){
                newState.message = `${newState.guess} is too big!`;
            } else if(newState.guess < action.number) {
                newState.message = `${newState.guess} is too small!`
            }
            return newState;
        }
        case "GUESS_CHANGE": {
            let newState = {...state};
            if(isNaN(action.guess)){
                console.log("not a number");
                return newState;
            }
            newState.guess = action.guess;
            return newState;
        }
        case "NEW_GAME": {
            let newState = {...state};
            newState.guess = "";
            newState.message = "";
            newState.pastGuesses = [];
            newState.number = getRandomNumber();
            newState.gameOver = false;
            return {...defaultGame};
        }
        default: {
            throw Error('numberReducer - unknown aciotn:', action,type);
        }
    }
}


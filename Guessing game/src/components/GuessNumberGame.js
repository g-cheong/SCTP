import { useReducer } from "react";
import { NumberReducer, defaultGame } from "../reducer/NumberReducer";




function GuessNumberGame() {
  const GUESS = "GUESS";
  const GUESS_CHANGE = "GUESS_CHANGE";
  const NEW_GAME = "NEW_GAME"
  const [state, dispatch] = useReducer(NumberReducer, defaultGame);
  const guessChangeHandler = (e) => {
    dispatch({type: GUESS_CHANGE, guess: e.target.value})
  };

  const guessHandler = () => {
    dispatch({type: GUESS})
  };

  const newGameHandler = () => {
    dispatch({type: NEW_GAME})
  };

  return (
    <div>
      <h1>Guess Number Game</h1>
      <p>Guess a number between 1 and 20.</p>
      <div className="guess-container">
        <label htmlFor="guess-input">Enter guess</label>
        <input
          id="guess-input"
          type="text"
          onChange={guessChangeHandler}
          value={state.guess}
        />
      </div>
      <div className="buttons-container">
        <button type="button" onClick={guessHandler} disabled={state.gameOver}>
          Guess!
        </button>
        <button type="button" onClick={newGameHandler}>
          New Game
        </button>
      </div>
      <p>{state.message}</p>
      <div className="guesses-container">
        {state.pastGuesses.map((pastGuess, i) => (
          <span key={i} className="guesses-number">
            {pastGuess}
          </span>
        ))}
      </div>
    </div>
  );
}

export default GuessNumberGame;

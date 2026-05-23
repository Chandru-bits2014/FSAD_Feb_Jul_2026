
import React, {useState} from 'react'

function Counter() {
    const [counter,setCounter] = useState(1);

    const incrementCounter = () =>{
            setCounter((prevCounter)=>prevCounter+1);
    }
    const decrementCounter = () =>{
            setCounter((prevCounter)=>prevCounter-1);
    }
  return (
    <div>
        Count {counter}
      <button onClick={incrementCounter}>+</button>
      <button onClick={decrementCounter}>-</button>
    </div>
  )
}

export default Counter

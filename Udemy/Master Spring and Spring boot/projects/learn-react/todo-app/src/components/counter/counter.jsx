import { useState } from 'react'
import './counter.css'

export default function Counter(){

    const [count, setCount]= useState(0);

    function incrementCounterFunction(val){
        
        setCount(count + val)
        console.log(count)
    }


    return (
        <>
            <div className="Counter">
                <span className="count">{count}</span>
                <div>
                    <button className="counterButton" onClick={() => incrementCounterFunction(1)}  >+1</button>
                    <button className="counterButton" onClick={() => incrementCounterFunction(-1)} >-1</button>
                </div>
            </div>
            <div className="Counter">
                <div>
                    <button className="counterButton" onClick={() =>  incrementCounterFunction(2)} >+2</button>
                    <button className="counterButton" onClick={() => incrementCounterFunction(-2)} >-2</button>
                </div>
            </div>
            <div className="Counter">
                <div>
                    <button className="counterButton" onClick={() =>  incrementCounterFunction(3)} >+3</button>
                    <button className="counterButton" onClick={() => incrementCounterFunction(-3)} >-3</button>
                </div>
            </div>
            <div className="Counter">
                <div>
                    <button className="counterButton" onClick={() =>  setCount(0)} >Reset</button>
                    
                </div>
            </div>
            
        </>
        
        
    )
}
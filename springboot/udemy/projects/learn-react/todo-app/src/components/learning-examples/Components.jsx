import { Component } from "react";

export function MyFirstComponent(){
    return (
      <div className="MyFirstComponent">First Component</div>
    )
  }

export  function MySecondComponent(){
    return (
        <div className="MySecondComponent">Second Component</div>
    )
}

export class MyThirdComponent extends Component{
    render(){
        return (
        <div className="MyThirdComponent">Third Component</div>
        )
    }
}  
  
export  class MyFourthComponent extends Component{
    render(){
    return (
        <div className="MyFourthComponent">Fourth Component</div>
    )
    }
}
    
export function MyFifthComponent(){
    return (
      <div className="MyFifthComponent">Fifth Component</div>
    )
}


export  function MysixthComponent(){
    return (
        <div className="MysixthComponent">Sixth Component</div>
    )
}

const person=   {
    firstName: 'Duy',
    age: 20,
    profiles: ['Twitter', 'Facebook', 'Instagram'], 
    displayProfile: () => {
        person.profiles.map(
            (profile) => {
                console.log(profile)
            }
        )
    }
}


export function DoSth(){
    return (
        <>
            <div className= "Do something">Do something 1</div>
            <div>{person.displayProfile()}</div>
        </>
       
    )
}
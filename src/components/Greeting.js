import { useState } from "react";
function Greeting({name, message}){
    const [messageState, setMessage] = useState(message);
    const changed =() => {
        setMessage('Im the DOPE')
    }
    return(
        <div>
            <h2> Hello, {name}</h2>
            <p> {messageState}</p>
            <button onClick={changed}> message Change</button>
        </div>
    ) ;
}

export default Greeting;
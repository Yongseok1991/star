import logo from './logo.svg';
import './App.css';
import React, {useState, useEffect, Component} from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
function App() {

  const [message, setMessage] = useState("[]");

  useEffect(() => {
    fetch("/api/list/1")
        .then( res => res.json())
        .then(message => setMessage(message))
  }, [])
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          {message.id}
          {message.userId}
          {message.userNm}
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn Reacts
        </a>
      </header>
    </div>
  );
}

export default App;

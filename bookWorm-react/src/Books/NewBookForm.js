import React, {Component} from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

class NewBookForm extends Component{
    constructor(props){
        super(props);
        console.log(props);
        this.state={
            bookName : '',
            author: '',
            numberOfPages: ''};

    }

    handleSubmit = (event)=> {
        axios.post('http://localhost:8081/newBook', {
            bookName: this.state.bookName, 
            author: this.state.author,
            numberOfPages: this.state.numberOfPages,
        })
        .catch ((error)=>{
            console.log(error);
        })
        console.log(this.state);
        event.preventDefault();
    }
    
    handleChange=(event)=>{
        this.setState({[event.target.name]:event.target.value})
    }

    render(){
        return(
            <div className="container">
            <form >
                <div className="form-group">
                    <label htmlFor="bookName">Knygos pavadinimas: </label>
                    <input type="text" name ="bookName" value={this.state.bookName} onChange={this.handleChange}/>
                </div><br/>
                <div className="form-group">
                    <label htmlFor="author">Autorius: </label>
                    <input type="text" name="author" value={this.state.author} onChange={this.handleChange}/>
                </div><br/>
                <div className="form-group">
                    <label htmlFor="numberOfPages">Puslapių skaičius: </label>
                    <input type="text" name="numberOfPages" value={this.state.numberOfPages} onChange={this.handleChange}/>
                </div><br/>
                <br/>
                <Link to="/books" role="button" type="save" className="btn btn-default" onClick={this.handleSubmit}>Išsaugoti</Link>
            </form>
            </div>); 
        }         
    }

export default NewBookForm;
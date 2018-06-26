import React, {Component} from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

class NewInstitutionForm extends Component{
    constructor(props){
        super(props);
        console.log(props);
        this.state={
            institutionName : '',
            /* institutionPhoto: '', */
            city: '',
            category: '',
            institutionType: '',
            subcategory: ''};

    }

    handleSubmit = (event)=> {
        axios.post('http://localhost:8081/newInstitution', {
            institutionName: this.state.institutionName, 
            city: this.state.city,
            category: this.state.category,
            institutionType: this.state.institutionType,
            subcategory: this.state.subcategory
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
                    <label htmlFor="institutionName">Institucijos pavadinimas: </label>
                    <input type="text" name ="institutionName" value={this.state.institutionName} onChange={this.handleChange}/>
                </div><br/>
                <div className="form-group">
                    <label htmlFor="city">Miestas: </label>
                    <input type="text" name="city" value={this.state.city} onChange={this.handleChange}/>
                </div><br/>
                <div className="form-group">
                    <label htmlFor="category">Kategorija: </label>
                    <input type="text" name="category" value={this.state.category} onChange={this.handleChange}/>
                </div><br/>
                <div className="form-group">
                    <label htmlFor="institutionType">Tipas: </label>
                    <input type="text" name="institutionType" value={this.state.institutionType} onChange={this.handleChange}/>
                </div><br/>    
                <div className="form-group">
                    <label htmlFor="subcategory">Subkategorija: </label>
                    <input type="text" name="subcategory" value={this.state.subcategory} onChange={this.handleChange}/>
                </div><br/>
                <br/>
                <Link to="/institutions" role="button" type="save" className="btn btn-default" onClick={this.handleSubmit}>Išsaugoti</Link>
            </form>
            </div>); 
        }         
    }

export default NewInstitutionForm;
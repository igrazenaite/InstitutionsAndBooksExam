import React, {Component} from 'react';
import { Link } from 'react-router-dom';
import BookTableComponent from './BookTableComponent';
import axios from 'axios';
import '../Style/NavBarStyle.css';
import '../Style/Icons.css';

class BookTableContainer extends Component{
    constructor() {
        super();

        this.state = {
            books: []
        }
    }

    componentWillMount(){
        axios
            .get("http://localhost:8081/books")
            .then((response) => {
                console.log(response);
                this.setState({books: response.data});
            })
            .catch((error) => {
                console.log(error);
            });
    }
    
    render (){
        return (
        <div>
            <nav className="navbar navbar-inverse navbar-fixed-top" id="navbarbooks">
                <div className="container-fluid">
                    <div className="navbar-header">
                        <a className="navbar-brand">Institucijos</a>
                    </div>
                        <ul className="nav navbar-nav">
                            <li><Link to={"/institutions"}>Institucijų sąrašas</Link></li>
                            <li className="active"><Link to={"/books"}>Knygų sąrašas</Link></li>
                        </ul>
                </div>
            </nav>
            <div className="container">
                <Link to={"/newBook"} >
                    <span className="glyphicon glyphicon-plus-sign" id="addNewIcon-top" ></span>
                </Link>
            </div>
            <div className="container">
                <BookTableComponent allBooks={this.state.books}/>
            </div>
            <div className="container">
                <Link to={"/newBook"} >
                    <span className="glyphicon glyphicon-plus-sign" id="addNewIcon-bottom" ></span>
                </Link>
            </div>
        </div>
      )
    }
}

export default BookTableContainer;
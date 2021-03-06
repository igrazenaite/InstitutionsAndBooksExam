import React, {Component} from 'react';
import { Link } from 'react-router-dom';
import InstitutionTableComponent from './InstitutionTableComponent';
import axios from 'axios';
import '../Style/NavBarStyle.css';
import '../Style/Icons.css';

class InstitutionTableContainer extends Component{
    constructor() {
        super();

        this.state = {
            institutions: [],
            institutionInfo: []
        }
    }

    componentWillMount(){
        axios
            .get("http://localhost:8081/institutions")
            .then((response) => {
                console.log(response);
                this.setState({institutions: response.data});
            })
            .catch((error) => {
                console.log(error);
            });
    }
    
    render (){
        console.log("table inst id ", this.state.institutionId);
        console.log("table inst info ", this.state.institutionInfo);
        return (
        <div>
            <nav className="navbar navbar-inverse navbar-fixed-top"  id="navbar">
                <div className="container-fluid">
                    <div className="navbar-header">
                        <a className="navbar-brand">Institucijos</a>
                    </div>
                        <ul className="nav navbar-nav">
                            <li className="active"><Link to={"/institutions"} >Institucijų sąrašas</Link></li>
                            <li><Link to={"/books"}>Knygų sąrašas</Link></li>
                        </ul>
                </div>
            </nav>
            <div className="container">
                <Link to={"/newInstitution"} >
                    <span className="glyphicon glyphicon-plus-sign" id="addNewIcon-top" ></span>
                </Link>
            </div>
            <div className="container">
                <InstitutionTableComponent allInstitutions={this.state.institutions}/>
            </div>
            <div className="container">
                <Link to={"/newInstitution"} >
                    <span className="glyphicon glyphicon-plus-sign" id="addNewIcon-bottom" ></span>
                </Link>
            </div>
        </div>
      )
    }
}

export default InstitutionTableContainer;
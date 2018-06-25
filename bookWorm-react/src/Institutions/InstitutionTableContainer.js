import React, {Component} from 'react';
import InstitutionTableComponent from './InstitutionTableComponent';
import axios from 'axios';

const style={
    marginTop:50
}

class InstitutionTableContainer extends Component{
    constructor() {
        super();

        this.state = {
            institutions: []
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
    goMain = () => this.props.router.push("/");
    
    render (){
        return (
        <div>
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand">Institucijos</a>
                    </div>
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">Institucijų sąrašas</a></li>
                            <li><a href="#">Knygų sąrašas</a></li>
                            <li><a href="#">Page 2</a></li>
                            <li><a href="#">Page 3</a></li>
                        </ul>
                </div>
            </nav>
            <div class="container" style={style}>
                <table class="table table-bordered">
                    <tr>
                        <th>Institucijos pavadinimas</th>
                        <th>Miestas</th>
                        <th>Kategorija</th>
                        <th>Tipas</th>
                        <th>Subkategorija</th>
                        <th>Daugiau</th>
                    </tr>
                
                    <InstitutionTableComponent allInstitutions={this.state.institutions}/>
                </table>
            </div>
        </div>
      )
    }
}

export default InstitutionTableContainer;
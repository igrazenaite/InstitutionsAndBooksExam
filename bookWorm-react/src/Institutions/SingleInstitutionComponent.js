import React, {Component} from 'react';
import plant from '../Habenaria_radiata.jpg';

class SingleInstitutionComponent extends Component{
  /* constructor (props){
    super(props);
  } */
    render(){
      return(
        <div className="caption">
          <p>Pavadinimas: {this.props.institution.institutionName}</p>
          <p>Miestas: {this.props.institution.city}</p>
          <p>Kategorija: {this.props.institution.category}</p>
          <p>Tipas: {this.props.institution.institutionType}</p>
          <p>Subkategorija: {this.props.institution.subcategory}</p>
        </div>
        );
    }
  };

export default SingleInstitutionComponent;
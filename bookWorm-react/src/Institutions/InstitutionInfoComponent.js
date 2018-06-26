import React from 'react';
//import plant from '../Habenaria_radiata.jpg';

var InstitutionInfoComponent=(props)=>{
  var singleInstitutionInfo = props.institution;
      return <div className="caption">
                {/* <p>{this.props.institution.institutionPhoto}</p> */}
                <p>Pavadinimas: {singleInstitutionInfo.institutionName}</p>
                <p>Miestas: {singleInstitutionInfo.city}</p>
                <p>Kategorija: {singleInstitutionInfo.category}</p>
                <p>Tipas: {singleInstitutionInfo.institutionType}</p>
                <p>Subkategorija: {singleInstitutionInfo.subcategory}</p>
              </div>    
    }

export default InstitutionInfoComponent;
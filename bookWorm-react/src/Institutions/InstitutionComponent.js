import React from 'react';
import './InstitutionComponentStyle.css'

var InstitutionComponent = (props)=>{
    var institution = props.singleInstitution;
    return  <tr>
                {/* <td>{institution.imageurl}</td> */}
                <td>{institution.institutionName}</td>
                <td>{institution.city}</td>
                <td>{institution.category}</td>
                <td>{institution.institutionType}</td>
                <td>{institution.subcategory}</td>
                <td><button className="btn btn-primary">Daugiau</button></td>
            </tr>

}

export default InstitutionComponent;
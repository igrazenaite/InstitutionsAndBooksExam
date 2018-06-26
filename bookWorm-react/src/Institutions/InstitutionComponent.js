import React from 'react';
import { Link } from 'react-router-dom';
import '../Style/ComponentStyle.css'
import '../Style/Icons.css'

var InstitutionComponent = (props)=>{
    var institution = props.singleInstitution;
    return  <tr>
                {/* <td>{institution.imageurl}</td> */}
                <td>{institution.institutionName}</td>
                <td>{institution.city}</td>
                <td>{institution.category}</td>
                <td>{institution.institutionType}</td>
                <td>{institution.subcategory}</td>
                <td>    
                    <Link to={"/singleInstitution/"+institution.institutionId} >
                        <span className="glyphicon glyphicon-info-sign" id="infoIcon" ></span>
                    </Link>
                    <a href="#">
                        <span className="glyphicon glyphicon-pencil" id="editIcon"></span>
                    </a>
                    <a href="#">
                        <span className="glyphicon glyphicon-trash" id="deleteIcon"></span>
                    </a>
                    {/* <button className="btn btn-primary">Daugiau</button> */}
                </td>
            </tr>

}

export default InstitutionComponent;
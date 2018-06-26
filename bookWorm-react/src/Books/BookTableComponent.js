import React from 'react';
import BookComponent from './BookComponent';

var BookTableComponent =(props)=>{

    var allBooks = props.allBooks;
    if (allBooks.length===0){
        return <div>All books from server</div>
    } else {
        var bookDrawing = allBooks.map((book)=>{
            return <BookComponent key={book.bookName} singleBook={book}/>
        })
        return <div class="container">
                    <table class="table table-bordered">
                        <tr>
                            {/* <th>Paveiksliukas</th> */}
                            <th>Knygos pavadinimas</th>
                            <th>Autorius</th>
                            <th>Puslapių skaičius</th>
                            <th>Daugiau</th>
                        </tr>
                            {bookDrawing}
                    </table>
                </div>
    }
};
export default BookTableComponent;
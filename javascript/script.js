const ht = new HashTable();

let atualSize = ht.tableSize();
let capacity = ht.capacity();
let collisions = getNumberOfColisions();

function update_table() {
	$('#here_table').empty();
	$('#here_table').append( '<thead><td>' + '<b>Valor</b>'  + '</td><td><b> Indice </b></td><td><b> Colisões </b></td></thead>' );
	 for(i=0;i<ht.size;i++){
	 	let value = (ht.table[i] === undefined ? 'Ø' : ht.table[i]);
	 	let col = (ht.collisions[i] === undefined ? 0 : ht.collisions[i]);
	    $('#here_table').append( '<tbody><td>' +  value + '</td>' + '<td>' + i + '</td><td>' + col +'</td></tbody>' );
	  }
	$('#here_table').append(  '</table>' );


	atualSize = ht.tableSize();
	capacity = ht.capacity();
	collisions = getNumberOfColisions();

	$('#size').empty();
	$('#cap').empty();
	$('#col').empty();

	$('#size').append(atualSize);
	$('#cap').append(capacity);
	$('#col').append(collisions);
}

function insert() {
	const value = $('#operation').val();
	ht.insert(value);
	$('#operation').val('');
	update_table();
}

function remove() {
	const value = $('#operation').val();
	ht.remove(value);
	$('#operation').val('');
	update_table();
}

function getNumberOfColisions() {
	let collisions = 0;
	for (let col of ht.collisions) {
		if (col !== undefined)
			collisions+=col
	}

	return collisions;
}

update_table();
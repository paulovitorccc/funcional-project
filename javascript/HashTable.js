class HashTable {
  
	constructor(size=10){
		this.table = new Array(size)
		this.collisions = new Array(size)
		this.size = size;
	}

	hash(value) {
		return (typeof value) === "number" ? (value % this.size)
										   : (value.toString().length % this.size);	
	}

	isEmpty() {
		return !this.table.some(
					(element) => {
						return (element ? true : false);
					}
				);
	}

	capacity() {
		return this.size;
	}

	tableSize() {
		return this.table.filter((element) => {return (element !== undefined && element !== 'removed')}).length;
	}

	indexOf(value) {
		return this._indexOfAux(value, this.hash(value))
	}

	insert(value) {
		let position = this.hash(value);
		return this._insertAux(position, value);
	}

	remove(value) {
		const index = this.indexOf(value);
		if (index === undefined) {
			alert('Element not found')
			return 'Element not found';
		}
		this.table[index] = 'removed';
	}

	search(value) {
		const index = this.indexOf(value);
		return (index === undefined ? undefined : this.table[index]);
	}

	toConsole() {
		console.table(this.table);
	}

	_insertAux(position, value) {

		if (this.table[position] === undefined || this.table[position] === 'removed') {
			// No collision case
			this.table[position] = value;
			this.collisions[position] = 0;

			this._tryGrowUp();

			return position; 
		} else {
			// Collision Case
			const canInsert = this._checkInsertion(position, value);

			if(canInsert) {
				this.collisions[position] = this.collisions[position] + 1;
				return this._insertAux(position+1, value)
			}

			alert('Duplicated elements not allowed');
			return 'Duplicated elements not allowed';
		}

	}

	_checkInsertion(position, value) {
		return (this.table[position] === value ? false : true);
	}

	_indexOfAux(value, atualIndex) {
		if(atualIndex >= this.size) atualIndex = 0;
		if(atualIndex === this.hash(value) - 1) return undefined;
		return this.table[atualIndex] === value ? atualIndex : this._indexOfAux(value, atualIndex + 1);
	}

	_tryGrowUp() {
		if (this.tableSize() > (this.size * 0.5)) {
			console.log('Table size duplicated');
			alert('Table size duplicated');
			this.size = this.size * 2;
			this.table[this.size] = undefined;
			this.collisions[this.size] = undefined;
		}
	}

}

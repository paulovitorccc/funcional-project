// hashtable (inicio)
class HashTable {
    constructor(size) {
      this.elements = 0;
      this.size = size;
      this.buckets = [];
      for (let i = 0; i < size; i++) {
        this.buckets.push(new this.elements([]));
      }
    }
    empty() {
      return this.elements === 0;
    }
    clear() {
      this.buckets.forEach(bucket => {
        bucket.clear();
      });
      this.elements = 0;
    }
    begin(item) {
        var previous = undefined; 
        if(this.hashFunction(item)){
            this.buckets[item] = item;
         }
        else {
            this.elements++;         
         }
         this.buckets[item] = item;
        return previous;
    }
    insert(item) {
      if (this.find(item)) return;
      let pos = this.hashFunction(item);
      this.buckets[pos].push_back(item);
      this.elements++;
    }
    erase(item) {
      const pos = this.hashFunction(item);
      const list = this.buckets[pos];
      const itemToErase = list.find(item);
      if (itemToErase !== list.end()) {
        list.erase(itemToErase);
        this.elements--;
      }
    }
    find(item) {
      let pos = this.hashFunction(item);
      return this.buckets[pos].find(item);
    }
    hashFunction(item) {
        return this.buckets.hasOwnProperty(item);
    }
  }
  
// hashtable (fim)

// implementando a function alert (inicio)
function alert(x){ 
    x === 'undefined' ? console.log('undefined') : console.log(x); return; 
 }; 
 alert('x'); alert();
// implementando a function alert (fim)

// teste (inicio)
var h = new HashTable({one: 1, two: 2, three: 3, "i'm no 4": 4});

console.log(h);
h.empty();
h.begin("anthony"); 
h.begin
console.log(h.elements);
console.log("O hashtble", h);
console.log("o bucket", h.buckets);
console.log("o tamanho", h.elements);

h.begin("bianca"); 
h.begin
console.log(h.elements);
console.log("O hashtble", h);
console.log("o bucket", h.buckets);
console.log("o tamanho", h.elements);

h.begin("anthony"); 
h.begin
console.log(h.elements);
console.log("O hashtble", h);
console.log("o bucket", h.buckets);
console.log("o tamanho", h.elements);

console.log(h.buckets);
console.log(h);

// teste (fim)
// hashtable (inicio)
function HashTable(obj)
{
    this.length = 0;
    this.items = {};
    for (var p in obj) {
        if (obj.hasOwnProperty(p)) {
            this.items[p] = obj[p];
            this.length++;
        }
    }

    this.setItem = function(key, value)
    {
        var previous = undefined;
        if (this.hasItem(key)) {
            previous = this.items[key];
        }
        else {
            this.length++;
        }
        this.items[key] = value;
        return previous;
    }

    this.getItem = function(key) {
        return this.hasItem(key) ? this.items[key] : undefined;
    }

    this.hasItem = function(key)
    {
        return this.items.hasOwnProperty(key);
    }
   
    this.removeItem = function(key)
    {
        if (this.hasItem(key)) {
            previous = this.items[key];
            this.length--;
            delete this.items[key];
            return previous;
        }
        else {
            return undefined;
        }
    }

    this.keys = function()
    {
        var keys = [];
        for (var k in this.items) {
            if (this.hasItem(k)) {
                keys.push(k);
            }
        }
        return keys;
    }

    this.values = function()
    {
        var values = [];
        for (var k in this.items) {
            if (this.hasItem(k)) {
                values.push(this.items[k]);
            }
        }
        return values;
    }

    this.each = function(fn) {
        for (var k in this.items) {
            if (this.hasItem(k)) {
                fn(k, this.items[k]);
            }
        }
    }

    this.clear = function()
    {
        this.items = {}
        this.length = 0;
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
h.setItem("anthony", 26); 
console.log(h.length);
console.log(h);
console.log(h.items.anthony);
console.log(h.length);
h.setItem("anthony", 27);
console.log(h.items.anthony);
console.log(h);

for (var k in h.items) {
    if (h.hasItem(k)) {
        alert('key is: ' + k + ', value is: ' + h.items[k]);
    }
}
// teste (fim)
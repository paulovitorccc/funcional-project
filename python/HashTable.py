class HashTable(object):
    table = [];
    def __init__ (self, size):
        self.table = [None]*size;
        
    def __isempty__ (self):
        return False if (len(list(filter(lambda e: (e != None and e != "DELETED"), self.table))) > 0) else True; 
        
    def __size__ (self):
        return len (list(filter(lambda e: e != None and e != "DELETED", self.table)));
        
    def __hash__ (self, item):
        return item % len(self.table);
    
    def __duplicatetable__ (self, item):
        newtable = self.table.copy();
        self.table = [None]*((len(self.table))*(2));
        for e in list(filter(lambda ele: ele != None and ele != "DELETED",newtable)):
            self.__insertaux__(e, self.__hash__ (e));
        self.__insertaux__(item, self.__hash__ (item));
        
    
    def __insert__ (self, item):
        return self.__duplicatetable__(item) if (self.__ishalffull__()) else self.__insertaux__(item, self.__hash__ (item));
        
    def __ishalffull__ (self):
        return True if(self.__size__()/(len(self.table)) >= 0.5) else False;
    
    def __insertaux__ (self, item, hashval):
        return self.__insertinarray__ (item, hashval) if (self.table[hashval] == None or self.table[hashval] == "DELETED") else self.__insertaux__ (item, (hashval + 1) % len(self.table));
    
    def __insertinarray__ (self, item, hashval):
        self.table[hashval] = item;
        return self.table;
    
    def __search__ (self,  item):
        return True if len(list(filter(lambda e: e == item, self.table))) > 0 else False;
    
    def __remove__ (self, item):
        return self.__removeaux__ (item, self.__hash__(item));
    
    def __removeaux__ (self, item, hashval):
        return self.table if (self.table[hashval] == None) else self.__removefromarray__(item, hashval) if  self.table[hashval] == item else self.__removeaux__(item,(hashval + 1) % len(self.table));
        
    def __removefromarray__ (self, item, hashval):
        self.table[hashval] = "DELETED";
        return self.table;
    
    def __indexof__ (self, item):
        return None if self.__search__(item) == False else list(filter( lambda i : self.table[i] == item, range(0, len(self.table))))[0];
    
    def __fromlist__ (self, mylist):
        for e in mylist:
            self.__insert__(e);
        return  self.table;

htable = HashTable(10);

print("Tabela vazia:")
print(htable.table)  
print("Verificando se a tabela está vazia:")
print(htable.__isempty__());
print("Tamanho da tabela:")
print(htable.__size__());
print("Inserindo elemento na tabela: ")
print(htable.__insert__(5));
print("Inserindo elemento repetido na tabela: ")
print(htable.__insert__(5));
print("Verificando tamanho após inserções:")
print(htable.__size__());
print("Procurando elemento que não existe na tabela:")
print(htable.__search__(4))
print("Procurando elemento que existe na tabela:")
print(htable.__search__(5))
print("Removendo elemento da tabela:")
print(htable.__remove__(5))
print("Removendo elemento da tabela:")
print(htable.__remove__(5))
print("Verificando se a tabela está vazia:")
print(htable.__isempty__());
lista = [4,8,7,6,1,9,2];
print("Inserindo os elementos de uma lista numa HashTable:")
print(htable.__fromlist__(lista));
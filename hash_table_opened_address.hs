module HashTable(
  insert,
  fromList,
  isEmpty,
  size,
  search,
  indexOf,
  remove,
  getCollisions
)
where

import qualified Data.Map as Map 

hashFunction k i = mod ((mod k 619) + i) 997

hash k i table 
  | Map.member key table = hash k (i+1) table 
  | otherwise = key
  where
    key = hashFunction k i

-- Pesquisa um determinado elemento na tabela de hash. 
-- Se não estiver na tabela, retorna false. 
search e table 
  | result == Map.empty = False
  | otherwise = True
  where
    result = Map.filter (== e) table

-- Insere um objeto não nulo na tabela de hash. O hashtable não trabalha 
-- com elementos duplicados
insert [] table = table
insert (x:xs) table
  | not (search x newTable) = Map.insert key x newTable
  | otherwise = newTable
  where
    key = (hash x 0 newTable)
    newTable = (insert xs table)

-- A partir de uma lista de elementos retorna sua respectiva tabela hash
fromList list = insert list Map.empty

-- Retorna se a tabela interna está fazia.
isEmpty table = table == Map.empty

-- Retorna quantos valores foram inseridos na tabela hash.
size table = Map.size table

-- Pesquisa o índice de um elemento na hashtable. Retorna -1 se o 
-- elemento não está no hashtable.
indexOf e table 
    | result == Map.empty = -1
    | otherwise = (Map.keys result) !! 0
    where
      result = Map.filter (== e) table

-- Remove um elemento da tabela hash.
remove e table 
    | key == -1 = table
    | otherwise = Map.delete key table
    where
      key = indexOf e table
  
count k i real_key
    | key == real_key = 0
    | otherwise = 1 + count k (i + 1) real_key
    where
      key = hashFunction k i

collisions [] = 0
collisions (x:xs) = c + collisions xs
      where
        c = count (snd x) 0 (fst x)

-- Retorna o numero de colisões que ocorreram na tabela.
getCollisions table = collisions (Map.toList table)

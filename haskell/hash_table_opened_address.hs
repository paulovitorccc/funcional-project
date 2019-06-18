module HashTable(
  insert,
  fromList,
  isEmpty,
  get_size,
  get_m,
  search,
  search_by_hash,
  indexOf,
  indexOf_by_hash,
  remove,
  getCollisions
)
where

import qualified Data.Map as Map 

-- Retorna quantos valores foram inseridos na tabela hash.
get_size table = fromIntegral (Map.size table)

get_m table = 997 * ((round ((get_size table) / 997)) + 1)

hashFunction k i table = mod ((mod k 619) + i) m 
  where
    m = get_m table

hash k i table 
  | not (Map.member key table) = key 
  | table Map.! key == "DELETED" = key
  | otherwise = hash k (i+1) table
  where
    key = hashFunction k i table

-- Pesquisa um determinado elemento na tabela de hash. 
-- Se não estiver na tabela, retorna false. 
search e table 
  | result == Map.empty = False
  | otherwise = True
  where
    result = Map.filter (== (show e)) table

fromJust (Just a) = a

search_aux elem i table
    | e == Nothing = False
    | (fromJust e) == (show elem) = True
    | otherwise = search_aux elem (i+1) table
    where
      e = Map.lookup key table
      key = hashFunction elem i table

-- Pesquisa um determinado elemento na tabela hash a partir da hash function
-- Se não estiver na tabela, retorna false.
search_by_hash elem table = search_aux elem 0 table

-- Insere um objeto não nulo na tabela de hash. O hashtable não trabalha 
-- com elementos duplicados
insert [] table = table
insert (x:xs) table
  | not (search x newTable) = Map.insert key (show x) newTable
  | otherwise = newTable
  where
    key = (hash x 0 newTable)
    newTable = (insert xs table)

-- A partir de uma lista de elementos retorna sua respectiva tabela hash
fromList list = insert list Map.empty

-- Retorna se a tabela interna está fazia.
isEmpty table = table == Map.empty

-- Pesquisa o índice de um elemento na hashtable. Retorna -1 se o 
-- elemento não está no hashtable.
indexOf e table 
    | result == Map.empty = -1
    | otherwise = (Map.keys result) !! 0
    where
      result = Map.filter (== (show e)) table

indexOf_aux elem i table
  | e == Nothing = -1
  | (fromJust e) == (show elem) = key
  | otherwise = indexOf_aux elem (i+1) table  
  where
    e = Map.lookup key table
    key = hashFunction elem i table

--Pesquisa o índice de um elemento na hashtable a partir da hash function
--Retorna -1 se o elemento não está no hashtable.
indexOf_by_hash elem table = indexOf_aux elem 0 table

-- Remove um elemento da tabela hash.
remove e table 
    | key == -1 = table
    | otherwise = Map.insert key "DELETED" table
    where
      key = indexOf e table
 
count k i real_key table
    | key == real_key = 0
    | otherwise = 1 + count k (i + 1) real_key table
    where
      key = hashFunction k i table

collisions [] _ = 0
collisions (x:xs) table = c + (collisions xs table)
      where
        c = count value 0 key table
        value = fromIntegral (read(snd x)::Int)
        key = fst x

-- Retorna o numero de colisões que ocorreram na tabela.
getCollisions table = collisions (Map.toList table) table

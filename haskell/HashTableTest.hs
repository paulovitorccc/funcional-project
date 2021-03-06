module HashTableTest where

import Test.HUnit
import HashTable as HashTable
import Data.Map as Map

hs = HashTable.fromList [300, 919, 1538, 2157, 2776, 3395, 4014, 4633, 5252, 5871, 6490, 7109]
conflitInsert1 = TestCase (assertEqual "tic1" "300" (hs Map.! 300))
conflitInsert2 = TestCase (assertEqual "tic2" "919" (hs Map.! 301))
conflitInsert3 = TestCase (assertEqual "tic3" "1538" (hs Map.! 302))
conflitInsert4 = TestCase (assertEqual "tic4" "2157" (hs Map.! 303))
conflitInsert5 = TestCase (assertEqual "tic5" "2776" (hs Map.! 304))
conflitInsert6 = TestCase (assertEqual "tic6" "3395" (hs Map.! 305))
conflitInsert7 = TestCase (assertEqual "tic7" "4014" (hs Map.! 306))
conflitInsert8 = TestCase (assertEqual "tic8" "4633" (hs Map.! 307))
conflitInsert9 = TestCase (assertEqual "tic9" "5252" (hs Map.! 308))
conflitInsert10 = TestCase (assertEqual "tic10" "5871" (hs Map.! 309))
conflitInsert11 = TestCase (assertEqual "tic11" "6490" (hs Map.! 310))
conflitInsert12 = TestCase (assertEqual "tic12" "7109" (hs Map.! 311))
conflictInsertTests = TestList [conflitInsert1, conflitInsert2, conflitInsert3, conflitInsert4, conflitInsert5, conflitInsert6, conflitInsert7, conflitInsert8, conflitInsert9, conflitInsert10, conflitInsert11, conflitInsert12] 

------------------------------------------

hsInsert = HashTable.fromList [20, 100, 2340, 4571, 3092]
insert1 = TestCase (assertEqual "ti1" "20" (hsInsert Map.! 20))
insert2 = TestCase (assertEqual "ti2" "100" (hsInsert Map.! 100))
insert3 = TestCase (assertEqual "ti3" "2340" (hsInsert Map.! 483))
insert4 = TestCase (assertEqual "ti4" "4571" (hsInsert Map.! 238))
insert5 = TestCase (assertEqual "ti5" "3092" (hsInsert Map.! 616))
insertTests = TestList [insert1, insert2, insert3, insert4, insert5]

------------------------------------------

hsRemove = HashTable.fromList [20, 100, 2340, 4571, 3092]
remove1 = TestCase (assertEqual "tr1" "DELETED" ((HashTable.remove 20 hsRemove) Map.! 20))
remove2 = TestCase (assertEqual "tr2" "DELETED" ((HashTable.remove 100 hsRemove) Map.! 100))
remove3 = TestCase (assertEqual "tr3" "DELETED" ((HashTable.remove 2340 hsRemove) Map.! 483))
remove4 = TestCase (assertEqual "tr4" "DELETED" ((HashTable.remove 4571 hsRemove) Map.! 238))
remove5 = TestCase (assertEqual "tr5" "DELETED" ((HashTable.remove 3092 hsRemove) Map.! 616))
removeTests = TestList [remove1, remove2, remove3, remove4, remove5]

------------------------------------------

hsDeleted = HashTable.fromList [300, 919, 1538, 2157, 2776]
hsDeletedAux = HashTable.remove 919 hsDeleted
hsDeletedEnd = HashTable.remove 2157 hsDeletedAux
hsRInsert1 = HashTable.insert [3395] hsDeletedEnd
hsRInsert2 = HashTable.insert [4014] hsRInsert1
riDeleted1 = TestCase (assertEqual "trid1" "3395" (hsRInsert1 Map.! 301))
riDeleted2 = TestCase (assertEqual "trid1" "DELETED" (hsRInsert1 Map.! 303))
riDeleted3 = TestCase (assertEqual "trid1" "4014" (hsRInsert2 Map.! 303))
riDeletedTests = TestList [riDeleted1, riDeleted2, riDeleted3]

------------------------------------------

tLabelInsert1 = TestLabel "Teste: Insert valores que geram conflito" conflictInsertTests
tLabelInsert2 = TestLabel "Teste: Insert valores que não geram conflito" insertTests
tLabelRemove1 = TestLabel "Teste: Remove valores" removeTests
tLabelRemove2 = TestLabel "Teste: Remove valores com mesmo hash e insere novos nas flags deleted" riDeletedTests

tAllInsert = TestList [tLabelInsert1, tLabelInsert2]
tAllRemove = TestList [tLabelRemove1, tLabelRemove2]
testAll = TestList [tAllInsert, tAllRemove]
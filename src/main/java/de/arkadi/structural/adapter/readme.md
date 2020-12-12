### Adapter
the adapter pattern do connect new and legacy code
and do not change the contract created by legacy code
- translate a client call to adapting to code
- examples: *Collections* API adapt Arrays to List
- needed only in legacy code
- provide different / another interface for legacy code then originally intended

###### Custom Example
-  we create an adapter which wraps the instance and rename / adjust the getters 

### Composite
it is a hierarchical pattern which deals tree structured data

- component represents part of a bigger structure, by configuring components in a tree structure.
- the component contain composites and leaves. The composites do have operations like the leaves,
  but do also have and know their children and can operate on and with them. Typicaly delegates the task to the children. 
  
You call a function on a composite object. This function do interact with all sub compose objects 
and return a value which contain all subcomponent state or functionality.

def emprunter(array)
  array.each do |element|
    print("#{element} ")
  end
  puts
end

def process(array, index)
  value = array[index]
  # starting from left of index, proceed leftward
  i = index - 1
  while (i >= 0 && array[i] > value)
    # shift array[i] one to the right
    array[i+1] = array[i]
    emprunter(array)
    i -= 1
  end
  # insert value into its rightful place
  array[i+1] = value
  emprunter(array)
end

array_size = gets.to_i
array = gets.split.map {|i| i.to_i}
process(array, array.length-1)

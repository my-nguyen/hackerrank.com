def lonely_integer(array)
  # hash with default value of 0
  hash = Hash.new(0)

  # go thru each element in array: at each encounter, the hash value for
  # that element is incremented
  array.each do |element|
    hash[element] += 1
  end

  # simply return the key with value of 1
  return hash.key(1)
end


# read and throw away the count because array length is the count
gets
puts(lonely_integer(gets.strip.split.map! {|i| i.to_i}))

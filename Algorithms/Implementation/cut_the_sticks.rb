def do_cut(param)
  cuts = []
  # a working sorted copy of the parameter array of integers
  numbers = param.sort
  # keep cutting while the working copy is not empty
  while numbers.empty? == false
    # current numbers size is the number of cuts
    cuts << numbers.length
    # remove all those elements whose length is smallest
    numbers.delete(numbers[0])
  end
  return cuts
end

# read and throw away this number
gets
do_cut(gets.split.map{|i| i.to_i}).each {|number| puts(number)}

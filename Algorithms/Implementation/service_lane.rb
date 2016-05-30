def process(widths, cases)
  minimums = []
  # test[0] is entry; test[1] is exit. widths[entry..exit] is the range in
  # which to find the minimum. all is needed is to sort the sub-array
  # widths[entry..exit], then take the first entry of the sorted sub-array
  cases.each do |test|
    minimums << widths[test[0]..test[1]].sort.first
  end
  return minimums
end

counts = gets.split.map {|i| i.to_i}
widths = gets.split.map {|i| i.to_i}
cases = []
counts[1].times do
  cases << gets.split.map {|i| i.to_i}
end

process(widths, cases).each do |minimum|
  puts(minimum)
end

def cut_chocolates(cuts)
  # number of chocolate pieces
  chocolates = 0
  increment = 0
  # assuming there's at least 2 cuts
  (2..cuts).each do |cut|
    # increase 'increment' by one at every two cuts
    if (cut % 2 == 0)
      increment += 1
    end
    chocolates += increment
  end
  return chocolates
end

gets.to_i.times do
  puts(cut_chocolates(gets.to_i))
end

require 'json'
require 'csv'

def player_from_json(p, team_id)
  return nil if p["nba"]["start"] == 0

  {
    "ID" => p["id"],
    "FirstName" => p["firstname"],
    "LastName" => p["lastname"],
    "BirthDate" => p["birth"]["date"],
    "BirthCountry" => p["birth"]["country"],
    "NBAStartYear" => p["nba"]["start"],
    "Height" => "#{p["height"]["feets"]} ft #{p["height"]["inches"]} in",
    "Weight" => p["weight"]["pounds"],
    "College" => p["college"],
    "Team" => team_id
  }
end

in_file = ARGV[0]

out_file = File.basename(in_file, ".json") + ".csv"

CSV.open(out_file, "w") do |csv|
  csv << ["ID", "FirstName", "LastName", "BirthDate", "BirthCountry", "NBAStartYear", "Height", "Weight", "College", "Team"]

  player_data = JSON.parse(File.read(ARGV[0]))
  player_data["response"].each do |p|
    row = player_from_json(p, player_data["parameters"]["team"])
    next if row.nil?

    csv << row.values
  end
end
